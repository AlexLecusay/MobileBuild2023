//
//  NotificationView.swift
//  RoaryMinder
//
//  Created by Zacharias Lafond on 3/7/23.
//  Copyright © 2023 orgName. All rights reserved.
//


import SwiftUI

struct NotificationView: View {
    var title: String
    var date: Date
    @State var isBellFilled = false // add state variable to track bell icon fill state
    var bellAction: () -> Void // Add a closure to handle the bell button action
    
    var body: some View {
        ZStack {
            HStack {
                // Title in top left corner
                Text(title)
                    .font(.headline)
                    .foregroundColor(.primary)
                    .padding(.leading)
                    .padding(.bottom, 40) // add padding between title and HStack bottom
                
                Spacer()
                
                // Bell icon in top right corner
                Button(action: {
                    isBellFilled.toggle() // toggle the state of isBellFilled
                    bellAction() // Call the closure when the bell button is tapped
                }) {
                    Image(systemName: isBellFilled ? "bell.fill" : "bell") // use conditional to change the icon based on the state
                        .foregroundColor(isBellFilled ? .red : .blue) // use conditional to change the color based on the state
                        .padding(.trailing)
                        .padding(.top)
                }
                
            }
            
            .overlay(
                VStack {
                    Spacer()
                    
                    // Date and time in bottom left corner
                    Text(formattedDate(date))
                        .font(.subheadline)
                        .foregroundColor(.secondary)
                        .padding(.leading)
                        .padding(.top)
                },
                alignment: .bottomLeading
                
            )
            .padding(10)
            .background(Color(UIColor.systemBackground))
            .cornerRadius(10)
            .shadow(color: Color.gray.opacity(0.1), radius: 1, x: 0, y: 1)
        }
    }

    }


    private func formattedDate(_ date: Date) -> String {
        let formatter = DateFormatter()
        formatter.dateFormat = "MM/dd/yyyy hh:mma"
        return formatter.string(from: date)
    }

    struct NotificationView_Previews: PreviewProvider {
        static var previews: some View {
            NotificationView(title: "New Notification", date: Date(), bellAction: {})
        }
    }

    struct Notification: Identifiable {
        var id = UUID()
        var title: String
        var date: Date
        var course: String
    }
