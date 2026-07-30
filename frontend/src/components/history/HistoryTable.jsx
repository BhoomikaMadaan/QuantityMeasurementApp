// Renders a list of QuantityMeasurementEntity rows, or a single count value.
// Includes a Delete action per row that is intentionally DISABLED: the
// backend (QuantityMeasurementController / IQuantityMeasurementService)
// does not expose a delete endpoint, and the requirements say not to modify
// the backend. Wiring this button to a nonexistent endpoint would silently
// fail, so it's disabled with an explanatory tooltip instead.
function HistoryTable({ mode, records, count }) {
  if (mode === 'count') {
    return (
      <div className="result-box">
        <h3>OPERATION COUNT</h3>
        <h1>{count ?? 0}</h1>
      </div>
    );
  }

  if (!records || records.length === 0) {
    return <p className="empty-state">No records found.</p>;
  }

  return (
    <table className="history-table">
      <thead>
        <tr>
          <th>ID</th>
          <th>Operation</th>
          <th>This</th>
          <th>Other</th>
          <th>Result</th>
          <th>Error</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        {records.map((r) => (
          <tr key={r.id} className={r.error ? 'row-error' : ''}>
            <td>{r.id}</td>
            <td>{r.operation}</td>
            <td>
              {r.thisValue} {r.thisUnit}
            </td>
            <td>
              {r.thatValue} {r.thatUnit}
            </td>
            <td>
              {r.error
                ? '—'
                : r.resultString ?? `${r.resultValue} ${r.resultUnit ?? ''}`}
            </td>
            <td>{r.error ? r.errorMessage : '—'}</td>
            <td>
              <button className="btn btn-danger" disabled title="Delete is not supported by the backend API">
                Delete
              </button>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default HistoryTable;