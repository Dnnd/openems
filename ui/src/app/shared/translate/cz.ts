export const TRANSLATION = {
    General: {
        Grid: "Síť",
        GridBuy: "Nákup ze sítě",
        GridSell: "Prodej do sítě",
        GridMode: "žádné připojení k síti!",
        Production: "Výroba",
        Consumption: "Spotřeba",
        Power: "Výkon",
        StorageSystem: "Systém bateriového úložiště",
        History: "Historie",
        NoValue: "Žádná hodnota",
        Soc: "Stav nabití",
        Percentage: "Procentuální vyjádření",
        More: "Další",
        ChargePower: "Nabíjecí výkon",
        DischargePower: "Vybíjecí výkon",
        PeriodFromTo: "od {{value1}} do {{value2}}", // value1 = beginning date, value2 = end date
        DateFormat: "dd.MM.yyyy", // e.g. German: dd.MM.yyyy, English: yyyy-MM-dd (dd = Day, MM = Month, yyyy = Year)
        Week: {
            Monday: "Pondělí",
            Tuesday: "Úterý",
            Wednesday: "Středa",
            Thursday: "Čtvrte",
            Friday: "Pátek",
            Saturday: "Sobota",
            Sunday: "Neděle"
        }
    },
    Menu: {
        Index: "Přehled",
        AboutUI: "About FEMS-UI",
        Settings: 'Obecné Nastavení',
        Logout: 'Odhlásit'
    },
    Index: {
        AllConnected: "Všechna připojení aktivní.",
        ConnectionSuccessful: "Úspěšně připojeno k {{value}}.", // value = name of websocket
        ConnectionFailed: "Připojení k {{value}} selhalo.", // value = name of websocket
        ToEnergymonitor: "Do Monitoringu energetických toků…",
        IsOffline: "FEMS je ve stavu offline!"
    },
    Edge: {
        Index: {
            Energymonitor: {
                Title: "Energetický monitor",
                ConsumptionWarning: "Spotřeba a neznámé výrobce",
                Storage: "Skladování",
                ReactivePower: "Reaktivní síla",
                ActivePower: "Aktivní napájení",
                GridMeter: "Měřič sítě",
                ProductionMeter: "Výrobní měřidlo",
                StorageDischarge: "Ukládání odpadu",
                StorageCharge: "Skladovací poplatek"
            },
            Energytable: {
                Title: "Tabulka hodnot",
                LoadingDC: "Načítání DC",
                ProductionDC: "Generování DC"
            },
            Widgets: {
                EVCS: {
                    ChargingStation: "Nabíjecí stanice",
                    Status: "Postavení",
                    Starting: "Začínající",
                    NotReadyForCharging: "Není připraven k nabíjení",
                    ReadyForCharging: "Připraven k nabíjení",
                    Charging: "Se nabíjí",
                    Error: "Chyba",
                    NotAuthorized: "Neautorizovaný",
                    Unplugged: "Odpojena",
                    ChargingStationPluggedIn: "Nabíjecí stanice zapojena",
                    ChargingStationPluggedInLocked: "Nabíjecí stanice zapojena + uzamčena",
                    ChargingStationPluggedInEV: "Nabíjecí stanice + e-car připojené",
                    ChargingStationPluggedInEVLocked: "Nabíjecí stanice + e-car připojené + uzamčena",
                    ChargingLimit: "Omezení nabíjení",
                    ChargingPower: "Nabíjecí výkon",
                    CurrentCharge: "Aktuální nabíjení",
                    TotalCharge: "Celkový poplatek",
                    EnforceCharging: "Prosazování poplatků",
                    Cable: "Kabel"
                }
            }
        },
        History: {
            SelectedPeriod: "Zvolené období: ",
            OtherPeriod: "Další období",
            Period: "Období",
            Today: "Dnes",
            Yesterday: "Včera",
            LastWeek: "Poslední týden",
            LastMonth: "Poslední měsíc",
            LastYear: "Poslední rok",
            Go: "Jdi!"
        },
        Config: {
            Index: {
                Bridge: "Připojená zařízení",
                Scheduler: "Plánovač aplikací",
                Controller: "Aplikace",
                Simulator: "Simulátor",
                ExecuteSimulator: "Zahájit simulaci",
                Log: "Log",
                LiveLog: "Live log systému",
                ManualControl: "Manuální ovládání",
                DataStorage: "Ukládání dat"
            },
            More: {
                ManualCommand: "Manuální příkaz ",
                Send: "Odeslat",
                RefuInverter: "REFU Střídač",
                RefuStartStop: "Start/Stop střídače",
                RefuStart: "Start",
                RefuStop: "Stop",
                ManualpqPowerSpecification: "Specifikace výkonu",
                ManualpqSubmit: "Zadání",
                ManualpqReset: "Reset"
            },
            Scheduler: {
                NewScheduler: "Nový plánovač...",
                Class: "Třída:",
                NotImplemented: "Zadání nebylo implementováno: ",
                Contact: "Došlo k chybě. Prosím kontaktujte <a href=\"mailto:{{value}}\">{{value}}</a>.", // value = Mail from FEMS-Team
                Always: "Vždy"
            },
            Log: {
                AutomaticUpdating: "Automatický update",
                Timestamp: "Časové razítko",
                Level: "Úroveň",
                Source: "Zdroj",
                Message: "Zpráva"
            },
            Controller: {
                InternallyID: "Vnitřní ID:",
                App: "App:",
                Priority: "Priorita:"
            },
            Bridge: {
                NewDevice: "Nové zařízení...",
                NewConnection: "Nové připojení..."
            }
        }
    },
    About: {
        UI: "Uživatelské rozhraní pro FEMS a OpenEMS",
        Developed: "Toto uživatelské rozhraní bylo vyvinuto společností FENECON jako open-source software.",
        Fenecon: "Více o společnosti FENECON",
        Fems: "Více o FEMS",
        Sourcecode: "Zdrojový kód",
        CurrentDevelopments: "Aktuální vývoj",
        Build: "Aktuální verze",
        Contact: "S případnými návrhy a pro další informace k systému prosím kontaktujte náš FEMS tým na <a href=\"mailto:{{value}}\">{{value}}</a>.", // value = Mail from FEMS-Team
        Language: "Zvolte jazyk:"
    },
    Notifications: {
        Failed: "Připojení selhalo.",
        LoggedInAs: "Uživatel přihlášen jako {{value}}.", // value = username
        LoggedIn: "Přihlášení proběhlo úspěšně.",
        AuthenticationFailed: "Žádné připojení: Ověření uživatele selhalo.",
        Closed: "Připojení ukončeno."
    }
}
