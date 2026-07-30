import { useState } from 'react';
import HistoryFilters from '../components/history/HistoryFilters.jsx';
import HistoryTable from '../components/history/HistoryTable.jsx';
import Alert from '../components/common/Alert.jsx';
import Loading from '../components/common/Loading.jsx';
import { useApiRequest } from '../hooks/useApiRequest.js';
import quantityService from '../services/quantityService.js';

function HistoryPage() {
  const [mode, setMode] = useState('operation'); // operation | type | count | errors
  const [operation, setOperation] = useState('COMPARE');
  const [measurementType, setMeasurementType] = useState('LengthUnit');
  const [records, setRecords] = useState(null);
  const [count, setCount] = useState(null);

  const { loading, error, execute, setError } = useApiRequest();

  const handleFetch = async () => {
    try {
      if (mode === 'operation') {
        const data = await execute(() => quantityService.getHistoryByOperation(operation));
        setRecords(data);
      } else if (mode === 'type') {
        const data = await execute(() => quantityService.getHistoryByType(measurementType));
        setRecords(data);
      } else if (mode === 'count') {
        const data = await execute(() => quantityService.getOperationCount(operation));
        setCount(data);
      } else if (mode === 'errors') {
        const data = await execute(() => quantityService.getErrorHistory());
        setRecords(data);
      }
    } catch {
      // handled by useApiRequest
    }
  };

  return (
    <div className="container">
      <header>Operation History</header>

      <HistoryFilters
        mode={mode}
        setMode={setMode}
        operation={operation}
        setOperation={setOperation}
        measurementType={measurementType}
        setMeasurementType={setMeasurementType}
        onFetch={handleFetch}
      />

      <Alert type="error" message={error} onClose={() => setError(null)} />

      {loading ? <Loading message="Fetching history..." /> : <HistoryTable mode={mode} records={records} count={count} />}
    </div>
  );
}

export default HistoryPage;