class AddLocationStringToHomes < ActiveRecord::Migration
  def change
    add_column :homes, :LocationString, :string
  end
end
