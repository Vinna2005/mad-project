const jwt = require('jsonwebtoken');

module.exports = function(req, res, next) {
  // Token lo header se
  const token = req.header('Authorization');

  // Token nahi hai
  if (!token) {
    return res.status(401).json({ message: 'No token, access denied' });
  }

  try {
    // Token verify karo
    const decoded = jwt.verify(
      token.replace('Bearer ', ''), 
      process.env.JWT_SECRET
    );
    req.user = decoded;
    next();
  } catch (err) {
    res.status(401).json({ message: 'Invalid token' });
  }
};