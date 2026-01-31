import Upload from "./Upload";
import Chat from "./Chat";
import MediaPlayer from "./MediaPlayer";

function App() {
  return (
    <div style={{ padding: "20px" }}>
      <h1>AI Multimedia Q&A</h1>

      <Upload />

      <hr />

      <Chat />

      <hr />

      <MediaPlayer />
    </div>
  );
}

export default App;
