import FormInput from '../common/FormInput.jsx';
import FormSelect from '../common/FormSelect.jsx';

// Renders the two input boxes. For "convert", the second box becomes the
// target unit picker (value2 hidden), matching the original app.js behavior.
function QuantityInputs({ action, units, value1, unit1, value2, unit2, onChange }) {
  const isConvert = action === 'convert';

  return (
    <div className="inputs">
      <div className="input-box">
        <h4>{isConvert ? 'Value' : 'First Quantity'}</h4>
        <FormInput id="value1" value={value1} onChange={(e) => onChange('value1', e.target.value)} placeholder="1" />
        <FormSelect id="unit1" value={unit1} onChange={(e) => onChange('unit1', e.target.value)} options={units} />
      </div>

      <div className="input-box">
        <h4>{isConvert ? 'Target Unit' : 'Second Quantity'}</h4>
        {!isConvert && (
          <FormInput
            id="value2"
            value={value2}
            onChange={(e) => onChange('value2', e.target.value)}
            placeholder="1000"
          />
        )}
        <FormSelect id="unit2" value={unit2} onChange={(e) => onChange('unit2', e.target.value)} options={units} />
      </div>
    </div>
  );
}

export default QuantityInputs;