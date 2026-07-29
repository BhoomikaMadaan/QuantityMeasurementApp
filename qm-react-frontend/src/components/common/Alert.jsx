// Displays success or error messages in the UI. type: 'success' | 'error'
function Alert({ type = 'error', message, onClose }) {
  if (!message) return null;

  return (
    <div className={`alert alert-${type}`}>
      <span>{message}</span>
      {onClose && (
        <button className="alert-close" onClick={onClose} aria-label="Dismiss">
          &times;
        </button>
      )}
    </div>
  );
}

export default Alert;