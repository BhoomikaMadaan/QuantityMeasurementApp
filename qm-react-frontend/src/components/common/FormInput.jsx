function FormInput({ label, id, type = 'number', value, onChange, placeholder }) {
  return (
    <div className="form-field">
      {label && <label htmlFor={id}>{label}</label>}
      <input id={id} type={type} value={value} onChange={onChange} placeholder={placeholder} />
    </div>
  );
}

export default FormInput;