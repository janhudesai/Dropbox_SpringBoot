// const api = process.env.REACT_APP_CONTACTS_API_URL || 'http://localhost:3001';

const api = process.env.REACT_APP_CONTACTS_API_URL || 'http://localhost:8080';

const headers = {
    'Accept': 'application/json'
};

//Changes for DEMO
export const doLogin = (payload) =>
    fetch(`${api}/user/login`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials:'include',
         body: JSON.stringify(payload)

    }).then(res => {
        console.log(res.status);
        return res.status;
    })

        .catch(error => {
            console.log("This is error");
            return error;
        });

// Lab 3
export const dosignup = (payload) =>
    fetch(`${api}/user/signup`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    }).then(res => {
        console.log(res.status);
        return res.status;
    })

        .catch(error => {
            console.log("This is error");
            return error;
        });

// Lab 3
export const douploadfile = (payload) =>
    fetch(`${api}/user/fileupload`,
        payload
    ).then(res => {
        console.log(res.status);
        return res.status;
    })

        .catch(error => {
            console.log("This is error");
            return error;
        });

// Lab 3
export const folder = (payload) =>
    fetch(`${api}/user/createdirectory`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    }).then(res => {
        console.log(res.status);
        return res.status;
    })

        .catch(error => {
            console.log("This is error");
            return error;
        });

// changes for DEMO
export const view = (payload) =>
    fetch(`${api}/user/list`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    }).then(function(resp) { return resp.json(); })

        .catch(error => {
            console.log("This is error");
            return error;
        });

// Changes fo lab 3
export const viewfiles = (payload) =>
    fetch(`${api}/user/listfiles`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    }).then(function(resp) { return resp.json(); })

        .catch(error => {
            console.log("This is error");
            return error;
        });

export const star = (payload) =>
    fetch(`${api}/users/star`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    }).then(function(resp) { return resp.json(); })

        .catch(error => {
            console.log("This is error");
            return error;
        });

// Lab 3
export const sharefolder = (payload) =>
    fetch(`${api}/user/createdirectoryshare`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    }).then(res => {
        console.log(res.status);
        return res.status;
    })

        .catch(error => {
            console.log("This is error");
            return error;
        });

// Lab 3
export const updatestar = (payload) =>
    fetch(`${api}/user/updatestar`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    }).then(res => {
        console.log(res.status);
        return res.status;
    })

        .catch(error => {
            console.log("This is error");
            return error;
        });

// Lab 3
export const childview = (payload) =>
    fetch(`${api}/user/childlist`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    }).then(function(resp) { return resp.json(); })

        .catch(error => {
            console.log("This is error");
            return error;
        });

// Lab 3
export const childviewfile = (payload) =>
    fetch(`${api}/user/childfiles`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    }).then(function(resp) { return resp.json(); })

        .catch(error => {
            console.log("This is error");
            return error;
        });

export const downloadfiles = (payload) =>
    fetch(`${api}/users/updateuseractivity2`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    }).then(function(resp) { return resp })

        .catch(error => {
            console.log("This is error");
            return error;
        });

// Lab 3
export const fileshare = (payload) =>
    fetch(`${api}/user/fileshare`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    }).then(res => {
        console.log(res.status);
        return res.status;
    })

        .catch(error => {
            console.log("This is error");
            return error;
        });

// Lab 3
export const useractivity = (payload) =>
    fetch(`${api}/user/useractivity`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    }).then(function(resp) { return resp.json(); })

        .catch(error => {
            console.log("This is error");
            return error;
        });

// Lab 3
export const updateuseractivity = (payload) =>
    fetch(`${api}/user/updateuseractivity`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    }).then(function(resp) { return resp.json(); })

        .catch(error => {
            console.log("This is error");
            return error;
        });

// Lab 3
export const activity = (payload) =>
    fetch(`${api}/user/activity`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    }).then(function(resp) { return resp.json(); })

        .catch(error => {
            console.log("This is error");
            return error;
        });

export const doLogout = (payload) =>
    fetch(`${api}/users/logout`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        credentials:'include',
        body: JSON.stringify(payload)

    }).then(res => {
        console.log(res.status);
        return res.status;
    })

        .catch(error => {
            console.log("This is error");
            return error;
        });

// Lab 3
export const onDelete = (payload) =>
    fetch(`${api}/user/delete`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    }).then(res => {
        console.log(res.status);
        return res.status;
    })

        .catch(error => {
            console.log("This is error");
            return error;
        });

// Lab 3
export const onDeleteFile = (payload) =>
    fetch(`${api}/user/deletefile`, {
        method: 'POST',
        headers: {
            ...headers,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    }).then(res => {
        console.log(res.status);
        return res.status;
    })

        .catch(error => {
            console.log("This is error");
            return error;
        });
