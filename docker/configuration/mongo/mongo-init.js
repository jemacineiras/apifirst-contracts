let dbAdmin = db.getSiblingDB("admin");
dbAdmin.createUser({
  user: "kloadgen",
  pwd: "kloadgen",
  roles: [{ role: "userAdminAnyDatabase", db: "admin" }],
  mechanisms: ["SCRAM-SHA-1"],
});

// Authenticate user
dbAdmin.auth({
  user: "kloadgen",
  pwd: "kloadgen",
  mechanisms: ["SCRAM-SHA-1"],
  digestPassword: true,
});

let dbDemo = db.getSiblingDB("bank-demo");
dbDemo.createUser({
  user: "kloadgen",
  pwd: "kloadgen",
  roles: [{ role: "readWrite", db: "bank-demo" }],
  mechanisms: ["SCRAM-SHA-1"],
});

db.createCollection("accounts");
db.createCollection("movements");