import React, { useState } from "react";

export default function Upload() {
  const [result, setResult] = useState("");

  const handleUpload = async (e) => {
    const file = e.target.files[0];
    if (!file) return;

    const formData = new FormData();
    formData.append("file", file);

    try {
      const res = await fetch("http://localhost:8080/api/upload", {
        method: "POST",
        body: formData
      });

      const data = await res.json();
      setResult(JSON.stringify(data, null, 2));
    } catch (err) {
      setResult("Upload failed");
    }
  };

  return (
    <div>
      <h2>Upload File</h2>
      <input type="file" onChange={handleUpload} />
      <pre>{result}</pre>
    </div>
  );
}
