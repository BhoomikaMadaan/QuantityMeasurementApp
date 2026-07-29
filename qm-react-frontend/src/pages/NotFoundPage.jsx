import { Link } from 'react-router-dom';

function NotFoundPage() {
  return (
    <div className="not-found">
      <h1>404</h1>
      <p>The page you're looking for doesn't exist.</p>
      <Link to="/">Go back home</Link>
    </div>
  );
}

export default NotFoundPage;