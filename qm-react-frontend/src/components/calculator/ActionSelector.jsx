import { ACTIONS } from '../../constants/units.js';

function ActionSelector({ selectedAction, onSelect }) {
  return (
    <div className="actions">
      {ACTIONS.map((a) => (
        <button
          key={a.key}
          className={selectedAction === a.key ? 'active' : ''}
          onClick={() => onSelect(a.key)}
        >
          {a.label}
        </button>
      ))}
    </div>
  );
}

export default ActionSelector;