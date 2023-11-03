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
    <div className={"flex flex-col w-screen h-screen"}>
      <h1 className={"text-3xl mt-10"}>Academy Database</h1>
      <Navbar
        displayStudents={displayStudents}
        displayFaculty={displayFaculty}
      />
      <div>
        <Spreadsheet students={students} faculty={faculty} />
      </div>
    </div>
  );
}

render(<App />, document.getElementById("app"));
