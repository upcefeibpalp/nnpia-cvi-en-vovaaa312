import { useState } from 'react';
import { Table, Button } from 'react-bootstrap';

interface User {
  id: number;
  username: string;
  email: string;
  role: string;
  active: boolean;
}

interface UserTableProps {
  users: User[];
}

const UserTable = ({ users }: UserTableProps) => {
  const [userList, setUserList] = useState(users);

  const toggleActive = (id: number) => {
    setUserList(userList.map(user =>
      user.id === id ? { ...user, active: !user.active } : user
    ));
  };

  return (
    <Table striped bordered hover>
      <thead>
        <tr>
          <th>ID</th>
          <th>Username</th>
          <th>Email</th>
          <th>Role</th>
          <th>Status</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
        {userList.map(user => (
          <tr key={user.id}>
            <td>{user.id}</td>
            <td>{user.username}</td>
            <td>{user.email}</td>
            <td>{user.role}</td>
            <td>{user.active ? 'Active' : 'Inactive'}</td>
            <td>
              <Button onClick={() => toggleActive(user.id)}>
                {user.active ? 'Deactivate' : 'Activate'}
              </Button>
            </td>
          </tr>
        ))}
      </tbody>
    </Table>
  );
};

export default UserTable;