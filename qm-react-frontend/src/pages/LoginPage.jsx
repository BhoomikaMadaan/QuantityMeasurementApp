import { useAuth } from '../hooks/useAuth.js';
import Button from '../components/common/Button.jsx';

function LoginPage() {
  const { login } = useAuth();

  return (
    <div className="login-page">
      <div className="login-card">
        <h1>Quantity Measurement</h1>
        <p>Sign in with your Google account to continue.</p>
        <Button onClick={login}>Sign in with Google</Button>
      </div>
    </div>
  );
}

export default LoginPage;