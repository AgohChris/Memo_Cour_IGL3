(function() {
    // Initialize ezstandalone if it doesn't exist
    window.ezstandalone = window.ezstandalone || {};
    ezstandalone.cmd = ezstandalone.cmd || [];

    // Push our ad insertion function to Ezoic's command queue
    ezstandalone.cmd.push(function() {
        function isMobile() {
            const isSmallScreen = window.innerWidth < 768; // Standard mobile breakpoint
            const isMobileUserAgent = /Mobi|Android|iPhone|iPad|iPod/.test(navigator.userAgent);
            return isSmallScreen || isMobileUserAgent;
        }

        function insertAdPlaceholders() {
            // Find the main content area
            const mainContent = document.getElementById('mainContent');
            if (!mainContent) {
                return;
            }

            // Find all h2 elements in the main content
            const h2Elements = mainContent.querySelectorAll('h2');

            // Define the ad placeholder IDs
            const mobilePlaceholders = [140, 141, 142, 143, 144];
            const desktopPlaceholders = [140, 141, 142];

            // Determine which set of placeholders to use based on device type
            const placeholders = isMobile() ? mobilePlaceholders : desktopPlaceholders;

            placeholders.forEach((id, index) => {
                // Target every 2nd h2 element, starting from the 2nd one (index 1)
                const h2 = h2Elements[index * 2 + 1];
                if (h2) {
                    // Create and insert the ad placeholder
                    const adElement = document.createElement('div');
                    adElement.id = `ezoic-pub-ad-placeholder-${id}`;
                    adElement.classList.add('clsEzoicAdv');
                    
                    h2.parentNode.insertBefore(adElement, h2);
                    // Load the Ezoic ad into the placeholder
                    ezstandalone.showAds(id);
                }
            });
        }

        // Run the ad insertion once when the script loads
        insertAdPlaceholders();
    });
})();
