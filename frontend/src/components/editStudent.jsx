import React, { useState } from "react";
import { Modal } from "@mui/material";

export default function EditStudent({
  showEditStudent,
  handleStudentClose,
  saveStudent,
  studentId,
}) {
  const [name, setName] = useState(studentId.name);
  const [email, setEmail] = useState(studentId.email);
  const [dob, setDob] = useState(studentId.dob);

  return (
    <div>
      <Modal open={showEditStudent} onClose={() => handleStudentClose()}>
        <div
          className={
            "absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 flex flex-col w-64 border-4 border-white p-4 rounded-md bg-gray-400"
          }
        >
          <label htmlFor="name">Name:</label>
          <input
            type="text"
            id="name"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
          <label htmlFor="email">Email:</label>
          <input
            type="text"
            id="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
          <label htmlFor="dob">DOB:</label>
          <input
            type="text"
            id="dob"
            value={dob}
            onChange={(e) => setDob(e.target.value)}
          />
          <div className={"ml-auto space-x-3 mt-3"}>
            <button
              className={
                "border border-white rounded-md bg-gray-400 p-2 font-bold hover:bg-white"
              }
              onClick={() => saveStudent(name, email, dob, studentId.id)}
            >
              Save
            </button>
            <button
              className={
                "border border-white rounded-md bg-gray-400 p-2 font-bold hover:bg-white"
              }
              onClick={() => handleStudentClose()}
            >
              Cancel
            </button>
          </div>
        </div>
      </Modal>
    </div>
  );
}
