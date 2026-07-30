import { useCallback, useState } from 'react';

// Generic hook wrapping any async API call with loading/error/data state,
// so every page handles loading spinners and error banners consistently.
export function useApiRequest() {
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  const [success, setSuccess] = useState(null);

  const execute = useCallback(async (apiCall, successMessage) => {
    setLoading(true);
    setError(null);
    setSuccess(null);
    try {
      const result = await apiCall();
      setData(result);
      if (successMessage) setSuccess(successMessage);
      return result;
    } catch (err) {
      setError(err.message || 'Request failed');
      throw err;
    } finally {
      setLoading(false);
    }
  }, []);

  const reset = useCallback(() => {
    setData(null);
    setError(null);
    setSuccess(null);
  }, []);

  return { data, loading, error, success, execute, reset, setError, setSuccess };
}