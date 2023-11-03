import React from 'react'

export default function Navbar() {
    return (
        <div>
            <ul className={"flex flex-row  space-x-6"}>
                <li>
                    <button className={"border border-white p-3 rounded-md bg-white text-black"}>All Students</button> 
                </li>
                <li>
                    <button className={"border border-white p-3 rounded-md bg-white text-black"}>All Faculty</button> 
                </li>
                <li>
                    <button className={"border border-white p-3 rounded-md bg-white text-black"}>Add Student</button> 
                </li>
                <li>
                    <button className={"border border-white p-3 rounded-md bg-white text-black"}>Add Faculty</button> 
                </li>
            </ul>
        </div>
    )
}