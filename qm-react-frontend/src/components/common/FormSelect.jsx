function FormSelect({ label, id, value, onChange, options }) {
  return (
    <div className="form-field">
      {label && <label htmlFor={id}>{label}</label>}
      <select id={id} value={value} onChange={onChange}>
        {options.map((opt) => (
          <option key={opt} value={opt}>
            {opt}
          </option>
        ))}
      </select>
    </div>
  );
}

export default FormSelect;