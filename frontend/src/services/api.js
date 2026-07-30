import axios from 'axios';

// Central Axios instance. Base URL comes from .env (VITE_API_BASE_URL).
// Backend CORS (SecurityConfig.corsConfigurationSource) already allows all
// origins/methods/headers, so no extra config is needed here.
const api = axios.create({
  baseURL: import.meta.env.VITE_API_BASE_URL || 'http://localhost:8080',
  headers: {
    'Content-Type': 'application/json',
  },
});

// Attach JWT if present (backend doesn't currently enforce it on any route,
// but this keeps the client ready if that changes later).
api.interceptors.request.use((config) => {
  const token = localStorage.getItem('jwt');
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

// Normalize error messages — GlobalExceptionHandler returns the error as a
// plain text body (not JSON), so we surface that text directly.
api.interceptors.response.use(
  (response) => response,
  (error) => {
    const message =
      (typeof error.response?.data === 'string' && error.response.data) ||
      error.response?.data?.message ||
      error.message ||
      'Something went wrong. Please try again.';
    return Promise.reject(new Error(message));
  }
);

export default api;