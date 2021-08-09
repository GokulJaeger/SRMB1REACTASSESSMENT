import React from 'react'

export default function AdErrorMessage({message}) {
    return (
        <div>
            { 
                message &&  <span className="error">{message}</span> 
            }
        </div>
    )
}