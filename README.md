# Quantity Measurement App — Microservices

The original monolith has been split into two independent Spring Boot
services plus the existing React frontend, unchanged:

```
QuantityMeasurementApp-Microservices/
├── authservice/        -> Spring Boot, port 8080
├── quantityservice/     -> Spring Boot, port 8081
└── frontend/            -> React + Vite (qm-react-frontend), port 5173
```

No business logic was rewritten — every Java class was moved as-is into
whichever service owns it. Only the plumbing needed to make two separate
apps boot correctly was added (new pom.xml per service, a renamed
`@SpringBootApplication` class per service, and per-service
`application.properties`).

## authservice (port 8080)

Owns everything related to login:
- `AuthController` — `/api/auth/success`
- `HomeController` — serves the legacy `/` template
- `config/SecurityConfig`, `JwtService`, `JwtDecoderConfig`,
  `OAuth2SuccessHandler` — Google OAuth2 login + JWT issuing
- `model/GoogleUserDTO`

**Important:** the existing frontend (`.env` → `VITE_API_BASE_URL`,
`src/services/api.js`, `src/services/authService.js`) hard-codes
`http://localhost:8080` for *every* API call — both auth and quantity
calls — and per your instructions the frontend was kept completely
unchanged. So that this still works with quantityservice moved to its
own port, `authservice` also includes one small addition:
`gateway/QuantityGatewayController`, which transparently forwards any
`/api/quantity/**` request it receives on 8080 to quantityservice on
8081 and streams the response straight back. It contains no business
logic — pure pass-through — so the two services remain independently
deployable; you can also call quantityservice directly on 8081 if you
update the frontend later.

## quantityservice (port 8081)

Owns all quantity-measurement logic, exactly as it was in the monolith:
- Domain classes: `IMeasurable`, `Quantity`, `LengthUnit`, `WeightUnit`,
  `VolumeUnit`, `TemperatureUnit`, `SupportsArithmetic`, `QuantityWeight`,
  `Length`
- `controller/QuantityMeasurementController` — `/api/quantity/**`
- `service`, `repository`, `model`, `exception`, `util` packages
- Its own H2 in-memory database (`quantitymeasurementdb`), JPA config,
  and `db/schema.sql`

Since this service has no login of its own, its `SecurityConfig` was
replaced with a plain `CorsConfig` (`WebMvcConfigurer`) that reproduces
the same permissive CORS behaviour the monolith's
`SecurityConfig.corsConfigurationSource()` provided, without pulling in
Spring Security / OAuth2 for a service that doesn't need it.

## frontend (port 5173)

Copied over verbatim (`node_modules` and `.git` excluded — run
`npm install` after copying). Nothing was touched: same `.env`, same
`vite.config.js` (dev proxy still points `/api` → `:8080`), same
services/components.

## Running everything

```bash
# 1. authservice
cd authservice
export GOOGLE_CLIENT_ID=...
export GOOGLE_CLIENT_SECRET=...
./mvnw spring-boot:run        # http://localhost:8080

# 2. quantityservice
cd quantityservice
./mvnw spring-boot:run        # http://localhost:8081

# 3. frontend
cd frontend
npm install
npm run dev                   # http://localhost:5173
```

`mvnw`/`mvnw.cmd` wrappers weren't included in this zip to keep it
small — run `mvn -N io.takari:maven:wrapper` in each service folder, or
just use your local Maven install (`mvn spring-boot:run`).
