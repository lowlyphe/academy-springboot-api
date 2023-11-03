import React, { useEffect } from "react";
import axios from "axios";
import Student from "./student";

export default function Spreadsheet({ students, faculty }) {
  if (students) {
    return students.map((student) => <Student student={student} />);
  }
}
