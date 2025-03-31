import UserTable from './UserTable';

function App() {
    const users = [
        { id: 1, username: 'john.doe', email: 'john.doe@example.com', role: 'USER', active: true },
        { id: 2, username: 'jane.doe', email: 'jane.doe@example.com', role: 'ADMIN', active: false },
        // Add more users as needed
    ];

    return (
        <div className="container">
            <title>NNPIA - Single-page application</title>
            <h1>NNPIA - Single-page application</h1>
            <UserTable users={users} />
        </div>
    );
}

export default App;