import api from './api.js';

// Builds the {quantity1, quantity2} body expected by QuantityRequestDTO.
function buildRequestBody(value1, unit1, value2, unit2) {
  return {
    quantity1: { value: Number(value1), unit: unit1 },
    quantity2: { value: Number(value2), unit: unit2 },
  };
}

const quantityService = {
  // POST /api/quantity/compare -> boolean
  compare: (value1, unit1, value2, unit2) =>
    api.post('/api/quantity/compare', buildRequestBody(value1, unit1, value2, unit2)).then((r) => r.data),

  // POST /api/quantity/convert -> Quantity<?> ({value, unit})
  // quantity2.unit is used as the target unit; quantity2.value is ignored by backend.
  convert: (value1, unit1, targetUnit) =>
    api.post('/api/quantity/convert', buildRequestBody(value1, unit1, 0, targetUnit)).then((r) => r.data),

  // POST /api/quantity/add -> Quantity<?>
  add: (value1, unit1, value2, unit2) =>
    api.post('/api/quantity/add', buildRequestBody(value1, unit1, value2, unit2)).then((r) => r.data),

  // POST /api/quantity/subtract -> Quantity<?>
  subtract: (value1, unit1, value2, unit2) =>
    api.post('/api/quantity/subtract', buildRequestBody(value1, unit1, value2, unit2)).then((r) => r.data),

  // POST /api/quantity/divide -> double
  divide: (value1, unit1, value2, unit2) =>
    api.post('/api/quantity/divide', buildRequestBody(value1, unit1, value2, unit2)).then((r) => r.data),

  // GET /api/quantity/history/operation/{operation} -> List<QuantityMeasurementEntity>
  getHistoryByOperation: (operation) =>
    api.get(`/api/quantity/history/operation/${operation}`).then((r) => r.data),

  // GET /api/quantity/history/type/{type} -> List<QuantityMeasurementEntity>
  getHistoryByType: (type) => api.get(`/api/quantity/history/type/${type}`).then((r) => r.data),

  // GET /api/quantity/count/{operation} -> Long
  getOperationCount: (operation) => api.get(`/api/quantity/count/${operation}`).then((r) => r.data),

  // GET /api/quantity/history/errored -> List<QuantityMeasurementEntity>
  getErrorHistory: () => api.get('/api/quantity/history/errored').then((r) => r.data),
};

export default quantityService;