import Student from "./student";
import Faculty from "./faculty";

export default function Spreadsheet({ students, handleStudentOpen, faculty }) {
  if (students.length > 0) {
    return (
      <div>
        <table className={"table-auto"}>
          <thead>
            <tr>
              <th>Name</th>
              <th>Email</th>
              <th>DOB</th>
              <th>Age</th>
              <th></th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            {students.map((student) => (
              <Student
                student={student}
                handleStudentOpen={handleStudentOpen}
              />
            ))}
          </tbody>
        </table>
      </div>
    );
  }
  if (faculty.length > 0) {
    return (
      <div>
        <table className={"table-auto"}>
          <thead>
            <tr className={"text-xs"}>
              <th>Employee ID</th>
              <th>Name</th>
              <th>Department</th>
              <th>Position</th>
              <th>Email</th>
              <th>Manager</th>
              <th>DOB</th>
              <th></th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            {faculty.map((faculty) => (
              <Faculty faculty={faculty} />
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}
