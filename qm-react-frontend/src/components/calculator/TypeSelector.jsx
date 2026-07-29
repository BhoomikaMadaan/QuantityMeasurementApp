import { MEASUREMENT_TYPES } from '../../constants/units.js';

function TypeSelector({ selectedType, onSelect }) {
  return (
    <div className="type-container">
      {MEASUREMENT_TYPES.map((t) => (
        <div
          key={t.key}
          className={`card ${selectedType === t.key ? 'active' : ''}`}
          onClick={() => onSelect(t.key)}
        >
          <img src={t.image} alt={t.label} />
          <p>{t.label}</p>
        </div>
      ))}
    </div>
  );
}

export default TypeSelector;