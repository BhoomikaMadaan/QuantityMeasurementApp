import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';

// Vite config: dev server proxies /api and /oauth2 to Spring Boot on :8080
// so you can call relative paths in dev without CORS issues, if you prefer
// that over the absolute VITE_API_BASE_URL approach used in services/api.js.
export default defineConfig({
  plugins: [react()],
  server: {
    port: 5173,
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true,
      },
    },
  },
});