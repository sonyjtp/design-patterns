# Observer Pattern

Observer Pattern defines a one-to-many dependency between objects so that when one object's state changes, all of its
dependents are notified and updated automatically.

- The Subject is only aware of an Observer Interface. It does not the latter's implementation.
- Add/remove observers any time without modifying subject's code.
- Reuse/change subjects/observers independently of each other.
