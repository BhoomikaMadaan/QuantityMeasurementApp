import { Routes, Route } from 'react-router-dom';
import ProtectedRoute from './ProtectedRoute.jsx';
import MainLayout from '../components/layout/MainLayout.jsx';
import LoginPage from '../pages/LoginPage.jsx';
import CalculatorPage from '../pages/CalculatorPage.jsx';
import HistoryPage from '../pages/HistoryPage.jsx';
import NotFoundPage from '../pages/NotFoundPage.jsx';

function AppRoutes() {
  return (
    <Routes>
      <Route path="/login" element={<LoginPage />} />

      <Route element={<ProtectedRoute />}>
        <Route element={<MainLayout />}>
          <Route path="/" element={<CalculatorPage />} />
          <Route path="/history" element={<HistoryPage />} />
        </Route>
      </Route>

      <Route path="*" element={<NotFoundPage />} />
    </Routes>
  );
}

export default AppRoutes;