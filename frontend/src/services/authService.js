const BASE_URL = import.meta.env.VITE_API_BASE_URL || 'http://localhost:8080';
const TOKEN_KEY = 'jwt';

// Kicks off the Spring Security OAuth2 login flow. This is a full browser
// redirect (not an Axios call) because Spring Security's oauth2Login()
// requires the browser to hit /oauth2/authorization/google directly.
function loginWithGoogle() {
  window.location.href = `${BASE_URL}/oauth2/authorization/google`;
}

function getToken() {
  return localStorage.getItem(TOKEN_KEY);
}

function setToken(token) {
  localStorage.setItem(TOKEN_KEY, token);
}

function logout() {
  localStorage.removeItem(TOKEN_KEY);
}

function isAuthenticated() {
  return Boolean(getToken());
}

export default { loginWithGoogle, getToken, setToken, logout, isAuthenticated };