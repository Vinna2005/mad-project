const express = require('express');
const router = express.Router();
const Item = require('../models/Item');
const auth = require('../middleware/auth');

// Saare items lao
router.get('/', auth, async (req, res) => {
  try {
    const items = await Item.find({ userId: req.user.id })
      .populate('categoryId');
    res.json(items);
  } catch (err) {
    res.status(500).json({ message: 'Server error' });
  }
});

// Expiry wale items lao (7 din mein expire hone wale)
router.get('/expiring', auth, async (req, res) => {
  try {
    const today = new Date();
    const next7Days = new Date();
    next7Days.setDate(today.getDate() + 7);

    const items = await Item.find({
      userId: req.user.id,
      expiryDate: { $gte: today, $lte: next7Days }
    }).populate('categoryId');

    res.json(items);
  } catch (err) {
    res.status(500).json({ message: 'Server error' });
  }
});

// Naya item banao
router.post('/', auth, async (req, res) => {
  try {
    const { name, expiryDate, categoryId, notes } = req.body;
    const item = new Item({
      name,
      expiryDate,
      categoryId,
      userId: req.user.id,
      notes
    });
    await item.save();
    res.status(201).json(item);
  } catch (err) {
    res.status(500).json({ message: 'Server error' });
  }
});

// Item update karo
router.put('/:id', auth, async (req, res) => {
  try {
    const item = await Item.findByIdAndUpdate(
      req.params.id,
      req.body,
      { new: true }
    );
    res.json(item);
  } catch (err) {
    res.status(500).json({ message: 'Server error' });
  }
});

// Item delete karo
router.delete('/:id', auth, async (req, res) => {
  try {
    await Item.findByIdAndDelete(req.params.id);
    res.json({ message: 'Item deleted' });
  } catch (err) {
    res.status(500).json({ message: 'Server error' });
  }
});

module.exports = router;