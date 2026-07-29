function ResultDisplay({ result }) {
  return (
    <div className="result-box">
      <h3>RESULT</h3>
      <h1>{result ?? '0'}</h1>
    </div>
  );
}

export default ResultDisplay;