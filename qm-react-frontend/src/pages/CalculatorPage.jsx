import { useState } from 'react';
import TypeSelector from '../components/calculator/TypeSelector.jsx';
import ActionSelector from '../components/calculator/ActionSelector.jsx';
import QuantityInputs from '../components/calculator/QuantityInputs.jsx';
import ResultDisplay from '../components/calculator/ResultDisplay.jsx';
import Alert from '../components/common/Alert.jsx';
import Loading from '../components/common/Loading.jsx';
import Button from '../components/common/Button.jsx';
import { UNITS_BY_TYPE } from '../constants/units.js';
import { useApiRequest } from '../hooks/useApiRequest.js';
import quantityService from '../services/quantityService.js';

function CalculatorPage() {
  const [type, setType] = useState('length');
  const [action, setAction] = useState('compare');
  const [value1, setValue1] = useState('');
  const [unit1, setUnit1] = useState(UNITS_BY_TYPE.length[0]);
  const [value2, setValue2] = useState('');
  const [unit2, setUnit2] = useState(UNITS_BY_TYPE.length[0]);
  const [result, setResult] = useState(null);

  const { loading, error, execute, setError } = useApiRequest();

  const handleTypeSelect = (newType) => {
    setType(newType);
    setUnit1(UNITS_BY_TYPE[newType][0]);
    setUnit2(UNITS_BY_TYPE[newType][0]);
    setResult(null);
  };

  const handleFieldChange = (field, val) => {
    if (field === 'value1') setValue1(val);
    if (field === 'value2') setValue2(val);
    if (field === 'unit1') setUnit1(val);
    if (field === 'unit2') setUnit2(val);
  };

  const formatResult = (data) => {
    if (typeof data === 'boolean') return data ? 'Quantities are EQUAL' : 'Quantities are NOT equal';
    if (typeof data === 'number') return data.toString();
    if (data && typeof data === 'object' && 'value' in data) return `${data.value} ${data.unit}`;
    return JSON.stringify(data);
  };

  const handleCalculate = async () => {
    if (value1 === '') {
      setError('Enter first value');
      return;
    }
    if (action !== 'convert' && value2 === '') {
      setError('Enter second value');
      return;
    }

    try {
      let data;
      if (action === 'compare') data = await execute(() => quantityService.compare(value1, unit1, value2, unit2));
      else if (action === 'convert') data = await execute(() => quantityService.convert(value1, unit1, unit2));
      else if (action === 'add') data = await execute(() => quantityService.add(value1, unit1, value2, unit2));
      else if (action === 'subtract') data = await execute(() => quantityService.subtract(value1, unit1, value2, unit2));
      else if (action === 'divide') data = await execute(() => quantityService.divide(value1, unit1, value2, unit2));

      setResult(formatResult(data));
    } catch {
      // error is already captured by useApiRequest
    }
  };

  return (
    <div className="container">
      <header>Welcome To Quantity Measurement</header>

      <h5>CHOOSE TYPE</h5>
      <TypeSelector selectedType={type} onSelect={handleTypeSelect} />

      <h5>CHOOSE ACTION</h5>
      <ActionSelector selectedAction={action} onSelect={setAction} />

      <QuantityInputs
        action={action}
        units={UNITS_BY_TYPE[type]}
        value1={value1}
        unit1={unit1}
        value2={value2}
        unit2={unit2}
        onChange={handleFieldChange}
      />

      <Alert type="error" message={error} onClose={() => setError(null)} />

      {loading ? <Loading message="Calculating..." /> : <ResultDisplay result={result} />}

      <Button variant="calculate" onClick={handleCalculate}>
        CALCULATE
      </Button>
    </div>
  );
}

export default CalculatorPage;