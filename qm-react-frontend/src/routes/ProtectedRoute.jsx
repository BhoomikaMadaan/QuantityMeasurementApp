import { Navigate, Outlet } from 'react-router-dom';
import { useAuth } from '../hooks/useAuth.js';
import Loading from '../components/common/Loading.jsx';

// Gate matching the original app.js behavior: if there's no jwt in
// localStorage, the user is sent to the login page instead of the
// Google redirect directly, so they see a proper login screen first.
function ProtectedRoute() {
  const { isAuthenticated, initializing } = useAuth();

  if (initializing) {
    return <Loading message="Checking session..." />;
  }

  if (!isAuthenticated) {
    return <Navigate to="/login" replace />;
  }

  return <Outlet />;
}

export default ProtectedRoute;