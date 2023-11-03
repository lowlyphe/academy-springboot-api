import { render } from "preact";
import "./style.css";
import Navbar from "./components/navbar";
import Spreadsheet from "./components/spreadsheet";
import axios from "axios";
import { useState } from "preact/hooks";

export function App() {
  const [students, setStudents] = useState([]);
  const [faculty, setFaculty] = useState([]);

  const displayStudents = async () => {
    const res = await axios.get("http://localhost:8080/api/v1/student");
    const students = res.data;
    setStudents([...students]);
  };

  const displayFaculty = async () => {
    const res = await axios.get("http://localhost:8080/api/v1/faculty");
    const faculty = res.data;
    setFaculty([...faculty]);
  };

  return (
    <>
      <Navbar
        displayStudents={displayStudents}
        displayFaculty={displayFaculty}
      />
      <Spreadsheet students={students} faculty={faculty} />
    </>
  );
}

render(<App />, document.getElementById("app"));
