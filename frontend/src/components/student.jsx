import React from "react";

export default function Student({ student, handleStudentOpen }) {
  return (
    <tr>
      <td>{student.name}</td>
      <td>{student.email}</td>
      <td>{student.dob}</td>
      <td>{student.age}</td>
      <td>
        <button
          className={
            "bg-green-500 w-24 text-white rounded-sm hover:bg-green-400"
          }
          onClick={() => handleStudentOpen(student.id)}
        >
          Edit
        </button>
      </td>
      <td>
        <button
          className={"bg-red-500 w-24 text-white rounded-sm hover:bg-red-400"}
        >
          Delete
        </button>
      </td>
    </tr>
  );
}
