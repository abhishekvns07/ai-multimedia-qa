import React, { useState } from "react";

export default function Chat() {
  const [question, setQuestion] = useState("");
  const [answer, setAnswer] = useState("");

  const ask = async () => {
    if (!question) return;

    try {
      const res = await fetch(
        "http://localhost:8080/api/chat?query=" +
          encodeURIComponent(question),
        { method: "POST" }
      );

      const data = await res.json();
      setAnswer(data.answer);
    } catch (err) {
      setAnswer("Chat failed");
    }
  };

  return (
    <div>
      <h2>Chatbot</h2>

      <input
        type="text"
        value={question}
        onChange={(e) => setQuestion(e.target.value)}
        placeholder="Ask about uploaded files"
        style={{ width: "400px" }}
      />

      <button onClick={ask} style={{ marginLeft: "10px" }}>
        Ask
      </button>

      <h3>Answer</h3>
      <pre>{answer}</pre>
    </div>
  );
}
