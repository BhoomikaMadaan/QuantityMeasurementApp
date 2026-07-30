// Reusable button component. `variant` maps to CSS classes defined in style.css.
function Button({ children, onClick, variant = 'primary', type = 'button', disabled = false, title }) {
  return (
    <button
      type={type}
      className={`btn btn-${variant}`}
      onClick={onClick}
      disabled={disabled}
      title={title}
    >
      {children}
    </button>
  );
}

export default Button;