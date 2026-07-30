import { NavLink } from 'react-router-dom';
import { useAuth } from '../../hooks/useAuth.js';
import { useTheme } from '../../hooks/useTheme.js';
import Button from '../common/Button.jsx';

function Navbar() {

  const { logout } = useAuth();
  const { theme, toggleTheme } = useTheme();

  return (
    <nav className="navbar">

      <div className="navbar-brand">
        Quantity Measurement
      </div>

      <div className="navbar-links">

        <NavLink
          to="/"
          end
          className={({ isActive }) =>
            isActive ? 'nav-link active' : 'nav-link'
          }
        >
          Calculator
        </NavLink>

        <NavLink
          to="/history"
          className={({ isActive }) =>
            isActive ? 'nav-link active' : 'nav-link'
          }
        >
          History
        </NavLink>

        <Button
          variant="secondary"
          onClick={toggleTheme}
        >
          {theme === "light" ? "🌙 Dark" : "☀ Light"}
        </Button>

        <Button
          variant="secondary"
          onClick={logout}
        >
          Logout
        </Button>

      </div>

    </nav>
  );
}

export default Navbar;