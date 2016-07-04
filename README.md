Task description:
This test is to create a Eclipse plugin, which will add a new Launch Configuration
Type, a "Composite Launch". Users will select existing configuration inside this Composite Launch.
When user execute "Run", all the selected configurations will be launched.

Notes:
- No dependencies needed.
- Tested on Windows 10 and Ubuntu Linux.
- No automatic or unitary tests

Future improvements:
- Proper check if a configuration supports the active mode (Run, Debug).
- Refactor the TableViewer into CheckboxTableViewer for better visualization.