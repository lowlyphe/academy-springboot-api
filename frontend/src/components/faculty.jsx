import React from "react";

export default function Faculty({ faculty }) {
  return (
    <tr>
      <td>{faculty.employeeId}</td>
      <td>{faculty.name}</td>
      <td>{faculty.department}</td>
      <td>{faculty.position}</td>
      <td>{faculty.email}</td>
      <td>{faculty.manager}</td>
      <td>{faculty.dob}</td>
      <td>
        <button
          className={
            "bg-green-500 w-24 text-white rounded-sm hover:bg-green-400"
          }
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
