import Student from "./student";
import Faculty from "./faculty";

export default function Spreadsheet({ students, faculty }) {
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
              <Student student={student} />
            ))}
          </tbody>
        </table>
      </div>
    );
  } else if (faculty.length > 0) {
    <div>
      <table className={"table-auto"}>
        <thead>
          <tr>
            <th>Employee ID</th>
            <th>Name</th>
            <th>Department</th>
            <th>Position</th>
            <th>Manager</th>
            <th>Email</th>
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
    </div>;
  }
}
