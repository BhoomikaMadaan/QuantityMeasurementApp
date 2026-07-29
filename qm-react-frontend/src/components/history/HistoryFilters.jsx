import { OPERATIONS, MEASUREMENT_TYPES } from '../../constants/units.js';
import Button from '../common/Button.jsx';

// Lets the user pick which of the 4 read endpoints to query.
function HistoryFilters({ mode, setMode, operation, setOperation, measurementType, setMeasurementType, onFetch }) {
  return (
    <div className="history-filters">
      <div className="history-tabs">
        <button className={mode === 'operation' ? 'active' : ''} onClick={() => setMode('operation')}>
          By Operation
        </button>
        <button className={mode === 'type' ? 'active' : ''} onClick={() => setMode('type')}>
          By Measurement Type
        </button>
        <button className={mode === 'count' ? 'active' : ''} onClick={() => setMode('count')}>
          Operation Count
        </button>
        <button className={mode === 'errors' ? 'active' : ''} onClick={() => setMode('errors')}>
          Error History
        </button>
      </div>

      {(mode === 'operation' || mode === 'count') && (
        <div className="form-field">
          <label htmlFor="operation">Operation</label>
          <select id="operation" value={operation} onChange={(e) => setOperation(e.target.value)}>
            {OPERATIONS.map((op) => (
              <option key={op} value={op}>
                {op}
              </option>
            ))}
          </select>
        </div>
      )}

      {mode === 'type' && (
        <div className="form-field">
          <label htmlFor="measurementType">Measurement Type</label>
          <select id="measurementType" value={measurementType} onChange={(e) => setMeasurementType(e.target.value)}>
            {MEASUREMENT_TYPES.map((t) => (
              <option key={t.backendType} value={t.backendType}>
                {t.label}
              </option>
            ))}
          </select>
        </div>
      )}

      <Button onClick={onFetch}>Fetch</Button>
    </div>
  );
}

export default HistoryFilters;