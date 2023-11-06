import { render } from "preact";
import "./style.css";
import Navbar from "./components/navbar";
import Spreadsheet from "./components/spreadsheet";
import axios from "axios";
import { useState } from "preact/hooks";
import EditStudent from "./components/editStudent";

export function App() {
  const [students, setStudents] = useState([]);
  const [faculty, setFaculty] = useState([]);
  const [showEditStudent, setShowEditStudent] = useState(false);
  const [showEditFaculty, setShowEditFaculty] = useState(false);
  const [studentClicked, setStudentClicked] = useState({
    id: null,
    name: null,
    email: null,
    dob: null,
  });

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

  const getStudent = (id) => {
    return axios.get("http://localhost:8080/api/v1/student/" + id);
  };

  const handleStudentOpen = async (id) => {
    setShowEditStudent(true);
    const student = await getStudent(id);
    setStudentClicked(student.data);
  };
  const handleStudentClose = () => setShowEditStudent(false);

  const editStudent = async (name, email, dob, id) => {
    let url = `http://localhost:8080/api/v1/student/${id}?`;
    if (name != null) {
      url += `name=${name}`;
    }
    if (email != null) {
      url += `email=${email}`;
    }
    if (dob != null) {
      url += `dob=${dob}`;
    }
    console.log(url);
    const res = await axios.put(url);
    console.log(res.data);
  };

  return (
    <div className={"flex flex-col w-screen h-screen"}>
      <h1 className={"text-3xl mt-10"}>Academy Database</h1>
      <Navbar
        displayStudents={displayStudents}
        displayFaculty={displayFaculty}
      />
      <div>
        <Spreadsheet
          students={students}
          handleStudentOpen={handleStudentOpen}
          faculty={faculty}
        />
      </div>
      <EditStudent
        showEditStudent={showEditStudent}
        handleStudentClose={handleStudentClose}
        saveStudent={editStudent}
        studentId={studentClicked}
      />
    </div>
  );
}

render(<App />, document.getElementById("app"));
