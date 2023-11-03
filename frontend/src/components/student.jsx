import React from "react";

export default function Student({ student }) {
  return (
    <ul className={"flex flex-row space-x-3"}>
      <li>{student.name}</li>
      <li>{student.email}</li>
      <li>{student.dob}</li>
      <li>{student.age}</li>
    </ul>
  );
}
