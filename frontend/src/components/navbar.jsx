import React from "react";

export default function Navbar({ displayStudents, displayFaculty }) {
  return (
    <div>
      <ul className={"flex flex-row"}>
        <li>
          <button
            className={
              "border border-black p-1 px-3 bg-gray-500 h-10 text-white hover:bg-white hover:text-black"
            }
            onClick={() => displayStudents()}
          >
            All Students
          </button>
        </li>
        <li>
          <button
            className={
              "border border-black p-1 px-3 bg-gray-500 h-10 text-white hover:bg-white hover:text-black"
            }
            onClick={() => displayFaculty()}
          >
            All Faculty
          </button>
        </li>
        <li>
          <button
            className={
              "border border-black p-1 px-3 bg-gray-500 h-10 text-white hover:bg-white hover:text-black"
            }
          >
            Add Student
          </button>
        </li>
        <li>
          <button
            className={
              "border border-black p-1 px-3 bg-gray-500 h-10 text-white hover:bg-white hover:text-black"
            }
          >
            Add Faculty
          </button>
        </li>
      </ul>
    </div>
  );
}
