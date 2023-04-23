db.auth('kloadgen', 'kloadgen')

db = db.getSiblingDB('bank-demo')

db.createUser({
  user: "kloadgen",
  pwd: "kloadgen",
  roles: [{ role: "readWrite", db: "bank-demo" }],
  mechanisms: ["SCRAM-SHA-1"],
});

db.createCollection("accounts");
db.createCollection("movements");