import React, { useRef, useState } from "react";

export default function MediaPlayer() {
  const videoRef = useRef(null);
  const [topic, setTopic] = useState("");
  const [ts, setTs] = useState("");

  const findAndPlay = async () => {
    if (!topic) return;

    try {
      const res = await fetch(
        "http://localhost:8080/api/media/timestamp?topic=" +
          encodeURIComponent(topic)
      );

      const data = await res.json();
      setTs(`Start: ${data.startTime}, End: ${data.endTime}`);

      if (videoRef.current) {
        videoRef.current.currentTime = data.startTime;
        videoRef.current.play();
      }
    } catch (err) {
      setTs("Failed to get timestamp");
    }
  };

  return (
    <div>
      <h2>Media Player</h2>

      {/* Replace with real uploaded media URL later */}
      <video
        ref={videoRef}
        width="400"
        controls
        src="http://localhost:8080/uploads/sample.mp4"
      />

      <div style={{ marginTop: "10px" }}>
        <input
          type="text"
          value={topic}
          onChange={(e) => setTopic(e.target.value)}
          placeholder="Enter topic"
        />

        <button onClick={findAndPlay} style={{ marginLeft: "10px" }}>
          Find & Play
        </button>
      </div>

      <pre>{ts}</pre>
    </div>
  );
}
