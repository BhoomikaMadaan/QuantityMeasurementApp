import { createContext, useEffect, useState } from 'react';
import authService from '../services/authService.js';

export const AuthContext = createContext(null);

// Provides auth state app-wide. On mount, checks the URL for a ?token=
// param — this is how the backend hands control back to the frontend
// after a successful Google login (OAuth2SuccessHandler redirects to
// "/?token=...").
export function AuthProvider({ children }) {
  const [token, setTokenState] = useState(authService.getToken());
  const [initializing, setInitializing] = useState(true);

  useEffect(() => {
    const params = new URLSearchParams(window.location.search);
    const incomingToken = params.get('token');

    if (incomingToken) {
      authService.setToken(incomingToken);
      setTokenState(incomingToken);
      // Strip the token from the URL bar without a full reload.
      params.delete('token');
      const newSearch = params.toString();
      const newUrl =
        window.location.pathname + (newSearch ? `?${newSearch}` : '') + window.location.hash;
      window.history.replaceState({}, '', newUrl);
    }

    setInitializing(false);
  }, []);

  const login = () => authService.loginWithGoogle();

  const logout = () => {
    authService.logout();
    setTokenState(null);
    window.location.href = '/login';
  };

  const value = {
    token,
    isAuthenticated: Boolean(token),
    initializing,
    login,
    logout,
  };

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
}