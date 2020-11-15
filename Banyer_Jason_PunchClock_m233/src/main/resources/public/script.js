const URL = 'http://localhost:8081';
let entries = [];

const dateAndTimeToDate = (dateString, timeString) => {
    return new Date(`${dateString}T${timeString}`).toISOString();
};

const createEntry = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const entry = {};
    entry['checkIn'] = dateAndTimeToDate(formData.get('checkInDate'), formData.get('checkInTime'));
    entry['checkOut'] = dateAndTimeToDate(formData.get('checkOutDate'), formData.get('checkOutTime'));

    fetch(`${URL}/entries`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(entry)
    }).then((result) => {
        result.json().then((entry) => {
            entries.push(entry);
            renderEntries();
        });
    });
};


const modifyEntry = (ME) => {
    ME.preventDefault();
    const formData = new FormData(ME.target);
    const entry = {};
    entry['IdToModifyEntry'] = id;

    modifyEntry(`${URL}/entries`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(id)
    }).then((result) => {
        result.json().then((id) => {
            entries.push(id);
            renderEntries();
        });
    });
};

const deleteEntry = (DE) => {
    DE.preventDefault();
    const formData = new FormData(DE.target);
    const entry = {};
    entry['IdToDeleteEntry'] = id;

    deleteEntry(`${URL}/entries`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(id)
    }).then((result) => {
        result.json().then((id) => {
            entries.push(id);
            renderEntries();
        });
    });
};


const createUser = (CU) => {
    CU.preventDefault();
    const formData = new FormData(CU.target);
    const user = {};
    user['username'] = username;
    user['password'] = password;
    user['role'] = role;
    createUser(`${URL}/users`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(username)
        body: JSON.stringify(password)
        body: JSON.stringify(role)
    }).then((result) => {
        result.json().then((username).then((password)).then((role)) => {
            user.push(username);
            user.push(password);
            user.push(role);
            renderUsers();
        });
    });
};

const modifyUser = (MU) => {
    MU.preventDefault();
    const formData = new FormData(MU.target);
    const user = {};
    user['username'] = username;
    user['password'] = password;
    user['role'] = role;
    modifyUser(`${URL}/users`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(username)
        body: JSON.stringify(password)
        body: JSON.stringify(role)
    }).then((result) => {
        result.json().then((username).then((password)).then((role)) => {
            user.push(username);
            user.push(password);
            user.push(role);
            renderUsers();
        });
    });
};

const deleteUser = (DU) => {
    DU.preventDefault();
    const formData = new FormData(DU.target);
    const user = {};
    user['username'] = username;
    user['password'] = password;
    user['role'] = role;
    deleteUser(`${URL}/users`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(username)
        body: JSON.stringify(password)
        body: JSON.stringify(role)
    }).then((result) => {
        result.json().then((username).then((password)).then((role)) => {
            user.push(username);
            user.push(password);
            user.push(role);
            renderUsers();
        });
    });
};

const indexEntries = () => {
    fetch(`${URL}/entries`, {
        method: 'GET'
    }).then((result) => {
        result.json().then((result) => {
            entries = result;
            renderEntries();
        });
    });
    renderEntries();
};

const createCell = (text) => {
    const cell = document.createElement('td');
    cell.innerText = text;
    return cell;
};

const renderEntries = () => {
    const display = document.querySelector('#entryDisplay');
    display.innerHTML = '';
    entries.forEach((entry) => {
        const row = document.createElement('tr');
        row.appendChild(createCell(entry.id));
        row.appendChild(createCell(new Date(entry.checkIn).toLocaleString()));
        row.appendChild(createCell(new Date(entry.checkOut).toLocaleString()));
        display.appendChild(row);
    });
};

document.addEventListener('DOMContentLoaded', function(){
    const createEntryForm = document.querySelector('#createEntryForm');
    createEntryForm.addEventListener('submit', createEntry);
    indexEntries();
});